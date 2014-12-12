Maven Seed for Enterprise Usage
================


## Goal

Serve as a starting point for enterprise and commercial maven-based development.
It doesn't have to be JAVA, could be other JVM based languages like Scala.


## Features

- Single and modular example.
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

cd maven4enterprise/modular-war
mvn install
```

### Site

It will generate the stie containing project information, test reports, and java documentations.

```
cd maven4enterprise/simple-war
mvn site

cd maven4enterprise/modular-war
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
cd maven4enterprise/simple-war
mvn deploy
```


### Release

The release process follows git-flow best practice.

```
cd maven4enterprise/simple-war
mvn jgitflow:release-start
```

Provide the version information in the interactive mode. At the backend, it will create a development branch if not exists and a release/$verison branch,
then switch to the release branch. After finishing the release work, run

```
mvn jgitflow:release-start
```

It will merge then changes to development, update the development POM to next SNAPSHOT, and tag the release to master branch.


## TOOD

- Linux based packaging like rpm, deb
- JRebel integration
- More realistic integration


## Origin

It is based on the [m4enterprise](https://code.google.com/p/m4enterprise/).

