# Run Conduktor Platform locally

1. Clone the conduktor-platform repo -> git clone https://github.com/conduktor/conduktor-platform.git
2. cd example-local/autorun --> sh autorun.sh setup

<img title="Conduktor Dashboard" alt="Conduktor Kafka Dashboard" src="/images/2023-07-12-Conduktor-Example.png">
   
<code>
sh autorun.sh setup

Downloading file from https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/autorun/autorun.sh

Welcome to Conduktor Platform installation script!
Go to https://github.com/conduktor/conduktor-platform if you need any help
Launching Conduktor Platform on your machine...

Downloading file from https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/docker-compose.yml
Downloading file from https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/jmx-exporter.yml
Downloading file from https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/platform-config-no-license.yaml
Downloading file from https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/platform-config.yaml
Downloading file from https://raw.githubusercontent.com/fsaintjacques/semver-tool/3.3.0/src/semver

To provide you with the best possible user experience, we need some information:

Organisation name: Your-Org-Name
Admin email 📧: Your-Email-ID
Admin password 🔒: Your-Password
License key [OPTIONAL]: 

Pulling Conduktor Platform docker images...
Starting Conduktor Platform (press CTRL+C to stop)

--> Go to http://localhost:8080 <--

</code>

### Usage

Run Conduktor Platform without installing any file, replace `<your-license>` by a value (without license you will only have free version):

```sh
curl -sS https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/autorun/autorun.sh | \
 LICENSE_TOKEN="<your-license>" bash -s setup
```

For local run, it will ask for inputs (like your license). You can also provide variables: 

```
LICENSE_TOKEN=""
ORGANIZATION_NAME=""
ADMIN_EMAIL=""
ADMIN_PSW=""
```

If you want to delete all Conduktor Platform data
```sh
curl -sS https://raw.githubusercontent.com/conduktor/conduktor-platform/main/example-local/autorun/autorun.sh | sh -s clean
```
### URL
Conduktor Platform is available on [http://localhost:8080](http://localhost:8080)

## Platform Url
[http://localhost:8080/home/](http://localhost:8080/home/)

### Credentials 
use the credentials your provided when running the script

## Requirements

- docker
