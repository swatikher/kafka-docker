# Example Schemas

Avro Schemas with validation and build jar.

Schema Registry - PI Schema Registry https://github.com/dsg-tech/pi-operational-inventory-schemas

examples of using org.apache.avro.SchemaBuilder https://www.programcreek.com/java-api-examples/index.php?api=org.apache.avro.SchemaBuilder

## Maven Build

```shell
mvn clean package
```

Generated classes will be in `target/generated-sources/avro`

The packaged jar will be in `target`. To make this jar available to other projects,
it must be either installed in the local Maven repo:

```shell
mvn clean install -U
```

After which the jar will be availble in `$HOME/.m2/repository/com/swatikher/schema/swatikher-schemas`. Other projects can
refer to this dependency like this:

```xml
<dependency>
    <groupId>com.swatikher.schema</groupId>
    <artifactId>swatikher-schemas</artifactId>
    <version>[1.0.0, 1.1.0)</version>
</dependency>
```

## Build a proper avro schema file to upload to schema registry

first, create an actual schema file as AVDL is not accepted by kafka-schema-registry

`avro-tools idl2schemata SKUMaster.avdl`

This will generate a **SKUMaster.avsc** file

## Upload to schema registry

navigate to localhost:3030

## Registering a Schema

1. **Make sure to first install jq**

```bash
sudo apt-get install jq
```

1. **export the avsc file to JSON**

```bash
export SCHEMA=$(jq tostring SKUMaster.avsc)
```

1. **Expose the port**

```bash
kubectl port-forward svc/schema-registry 8081:8081
```

1. **Ppload to schema registry**

```bash
curl -XPOST -H "Content-Type:application/json" -d"{\"schema\":$SCHEMA}" http://localhost:8081/subjects/schemaName/versions
```
