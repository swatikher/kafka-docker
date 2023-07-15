import os
from flask import Flask, render_template

app = Flask(__name__)

port = int(os.environ.get('PORT', 3000))


@app.route('/')
def main():
    return render_template("main.html")

#@app.route('/dashboard/')
#def dashboard():
#    return render_template("dashboard.html")

@app.route('/hello')
def hello():
    myString = "Hello World!\n"
    myupdate = "2023-06-22 Updated myapp\n"
    myupdate2 = "2023-06-22 skher made an update\n"
    strjoin = myString + myupdate + myupdate2
    return "Hello world!\n" +  "\n" + myupdate + myupdate2


if __name__ == '__main__':
    app.run('0.0.0.0', port=port)
