#!/usr/bin/env groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' ) 

  

  

import groovy.json.* 

import groovyx.net.http.* 

import static groovyx.net.http.ContentType.* 

import static groovyx.net.http.Method.* 

  

  

def http = new HTTPBuilder( 'https://my.atlassian.com/download/feeds/current/jira-software.json' ) 

http.setProxy('10.99.202.104', 1212, 'http') 

http.request(GET,TEXT) { req -> 

      response.success = { resp, reader -> 

      result = reader.text 

    } 

} 
