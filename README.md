Maven Seed for Enterprise Usage
================


## Goal

Serve as a starting point for enterprise and commercial maven-based development.

## Features

- Single and modular examples
- Centralized `corporate-pom` to manage the settings of
    - Encoding
    - Compiler version
    - SCM
    - Style Check
    - PMD and FindBug
    - Reporting
    - Essential maven plugins by groups
- Sites
    - Project information
    - Unit and Integration Test
    - JavaDoc, Xref Source Code
- Deployment automation
    - artifacts deployment to repository
    - application deployment
- Git flow for releasing



## Usage


### Requirement

- JDK
- Maven

### Check out the source code

```
git clone https://github.com/tongqqiu/maven4enterprise.git
```

### Build, Install, and Site


```
cd maven4enterprise/simple-war
mvn install
cd ../modular-war
mvn install
```

### Site

It will generate the site containing project information, test reports, and java documentations.

```
cd ../simple-war
mvn site
cd ../modular-war
mvn site
```


### Artifacts Deployment

Before you try artifacts deployment, the deployment location must be configured.
In corporate world it should be an enterprise repository, but for testing purposes local directory can be used as well.
The easiest way to do that is to add the following profile to `$HOME/.m2/settings.xml` file:

```
<profiles>
<profile>
  <id>m4enterprise</id>
  <properties>
    <acme-corporate-pom.releaseRepositoryUrl>file://${env.HOME}/.m4enterprise/releases</acme-corporate-pom.releaseRepositoryUrl>
    <acme-corporate-pom.snapshotRepositoryUrl>file://${env.HOME}/.m4enterprise/snapshots</acme-corporate-pom.snapshotRepositoryUrl>
    <acme-corporate-pom.siteRepositoryUrl>file://${env.HOME}/.m4enterprise/sites</acme-corporate-pom.siteRepositoryUrl>
  </properties>
</profile>
<profiles>
<activeProfiles>
  <activeProfile>m4enterprise</activeProfile>
</activeProfiles>
```


Then

```
cd ../simple-war
mvn deploy
```

### Application Deployment

The example is under `modular-war/modular-war-deploy`. It provides the examples of using maven profiles to deploy applications to different envrionment, via ssh or wagon.
I personally do not recommend to do application deployment from maven other than local deployment. Maven should publish artifacts to repository,
and let the IT automation tools like Ansible or puppet to do deployment.



```
cd ../modular-war
mvn -P env-dev,deploy
```

### Assembly

In many cases, we need to package not only jar/war, but also configurations and scripts as a whole distribution.
Here is an example to assemble as `tgz`.

```
cd ../module-war
mvn -P dist
```

In many other cases, we want to build a linux installer like rpm or deb packages, besides of `tgz`.
In our example profile `rpm`, we use [`fpm`](https://github.com/jordansissel/fpm) as a tool, since it supports a wide range of packaging options.
You need to install `fpm` and `rpmbuild` to make it work. Note that `rpm` usually requires extra scripts before and after
rpm installation. It is out of scope of this seed project.

```
mvn -P rpm
```

### Release

Remember to configure 'scm' part correctly.
The release process follows [git-flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) best practice.

```
cd ../simple-war
mvn jgitflow:release-start
```

Provide the version information in the interactive mode. At the backend, it will create a development branch if not exists and a release/$verison branch,
then switch to the release branch. After finishing the release work, run

```
mvn jgitflow:release-start
```

It will merge then changes to development branch, update the development POM to next SNAPSHOT, and tag the release version to master branch.


## TOOD

- More realistic integration tests
- Deeper JRebel integration


## Origin

It is based on the [m4enterprise](https://code.google.com/p/m4enterprise/).

