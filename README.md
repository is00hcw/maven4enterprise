maven4enterprise
================

maven seed for enterprise

## Goal

- Serve as a ready-to-use starting point for enterprise and commercial maven-based (not have to be JAVA, could by any JVM based language) development.

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
mvn site

cd maven4enterprise/modular-war
mvn install
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