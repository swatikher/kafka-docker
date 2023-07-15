# sk-examples-kafka

Python script to run Flask Dashboard

<p><code>python3 server.py
 * Serving Flask app 'server'
 * Debug mode: off
 * Running on all addresses (0.0.0.0)
 * Running on http://127.0.0.1:3000
 * Running on http://10.0.0.29:3000
Press CTRL+C to quit</code></p>

Launch or deploy as CloudFoundry App
https://apps.sys.ap03.pcf.dcsg.com 

Deployed in following environment
https://myapp-active-turtle-xh.apps.ap03.pcf.mydomain.com/ 

<p> <i> 
 RUNNING  myapp  1	133.12 MB	7 d 0 hr
     https://myapp-active-turtle-xh.apps.ap03.pcf.mydomain.com
</i>  </p>
 

 <p> <b>
  This is the CloudFoundry CLI
 </b>
 </p> 

<p><b>
 cf7.exe push
</b>
</p>

 <p>
  <code>
   Pushing app myapp to org integration / space prod as swati.kher@mydomain.com...
Applying manifest file C:\Users\myGitrepo\python-tutorial\manifest.yml...
Manifest applied
Packaging files to upload...
Uploading files...
 1.04 KiB / 1.04 KiB  100.00% 1s

Waiting for API to complete processing files...

Staging app and tracing logs...
   Downloading python_buildpack...
   Downloaded python_buildpack
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe creating container for instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe failed to create container for instance 0e65ff8f-151f-47c5-b672-83065da749f0: external networker up: exit status 1
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe destroying container for instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe successfully destroyed container for instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Downloading python_buildpack...
   Downloaded python_buildpack
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe creating container for instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe successfully created container for instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Downloading app package...
   Downloading build artifacts cache...
   Downloaded app package (1K)
   Downloaded build artifacts cache (692.4K)
   -----> Python Buildpack version 1.8.11
   -----> Supplying Python
   -----> Installing python 3.10.12
          Copy [/tmp/buildpacks/b91fec733a90f99875cc1ea31a3ab19b/dependencies/b81df7f253dac51fffe26e649d48a18f/python_3.10.12_linux_x64_cflinuxfs3_d2aff6f1.tgz]
          Using python's pip module
          pip 23.0.1 from /tmp/contents1601708836/deps/0/python/lib/python3.10/site-packages/pip (python 3.10)
   -----> Running Pip Install (Unvendored)
          python -m pip install -r /tmp/app/requirements.txt --ignore-installed --exists-action=w --src=/tmp/contents1601708836/deps/0/src --disable-pip-version-check --no-warn-script-location
          Collecting Flask==2.0.1
            Using cached Flask-2.0.1-py3-none-any.whl (94 kB)
          Collecting Werkzeug>=2.0
            Using cached Werkzeug-2.3.6-py3-none-any.whl (242 kB)
          Collecting itsdangerous>=2.0
            Using cached itsdangerous-2.1.2-py3-none-any.whl (15 kB)
          Collecting Jinja2>=3.0
            Using cached Jinja2-3.1.2-py3-none-any.whl (133 kB)
          Collecting click>=7.1.2
            Using cached click-8.1.3-py3-none-any.whl (96 kB)
          Collecting MarkupSafe>=2.0
            Using cached MarkupSafe-2.1.3-cp310-cp310-manylinux_2_17_x86_64.manylinux2014_x86_64.whl (25 kB)
          Installing collected packages: MarkupSafe, itsdangerous, click, Werkzeug, Jinja2, Flask
          Successfully installed Flask-2.0.1 Jinja2-3.1.2 MarkupSafe-2.1.3 Werkzeug-2.3.6 click-8.1.3 itsdangerous-2.1.2
   No start command specified by buildpack or via Procfile.
   App will not start unless a command is provided at runtime.
   Exit status 0
   Uploading droplet, build artifacts cache...
   Uploading droplet...
   Uploading build artifacts cache...
   Uploaded build artifacts cache (692.4K)
   Uploaded droplet (63.9M)
   Uploading complete
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe stopping instance 0e65ff8f-151f-47c5-b672-83065da749f0
   Cell 9a058bfe-29f1-439a-852d-3606ef3b21fe destroying container for instance 0e65ff8f-151f-47c5-b672-83065da749f0

Waiting for app myapp to start...

Instances starting...
Instances starting...
Instances starting...
Instances starting...
Instances starting...

name:              myapp
requested state:   started
routes:            myapp-active-turtle-xh.apps.ap03.pcf.mydomain.com
last uploaded:     Thu 22 Jun 06:59:08 PDT 2023
stack:             cflinuxfs3
buildpacks:
        name               version   detect output   buildpack name
        python_buildpack   1.8.11    python          python

type:            web
sidecars:
instances:       1/1
memory usage:    128M
start command:   python server.py
     state     since                  cpu    memory      disk        details
#0   running   2023-06-22T13:59:25Z   0.0%   0 of 128M   51M of 1G
  </code>
 </p>
