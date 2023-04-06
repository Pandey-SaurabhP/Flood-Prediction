# Importing flask module in the project is mandatory
# An object of Flask class is our WSGI application.
from flask import Flask, request
from controller.fuzzysearch import fuzzysearch 

# Flask constructor takes the name of
# current module (__name__) as argument.
app = Flask(__name__)

# The route() function of the Flask class is a decorator,
# which tells the application which URL should call
# the associated function.
@app.route('/search')
# ‘/’ URL is bound with hello_world() function.
def search():
	return str(__name__)

@app.route('/panic')
def panic():
	return str("name gola")

@app.route('/fuzzysearch')
def fuzzy_search():
	return fuzzysearch.fuzzySearch()

# main driver function
if __name__ == '__main__':

	# run() method of Flask class runs the application
	# on the local development server.
	app.run(port="8000")
