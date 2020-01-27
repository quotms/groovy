#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' ) 

import groovy.json.* 
import groovyx.net.http.* 
import static groovyx.net.http.ContentType.* 
import static groovyx.net.http.Method.* 

def http = new HTTPBuilder( 'https://my.atlassian.com/download/feeds/current/jira-software.json' ) 
http.request(GET,TEXT) { req -> 

      response.success = { resp, reader -> 

      result = reader.text 

    } 

}

def extract = result =~ /^downloads\((.+)\)$/ 
  if (!extract.matches()) { 
    throw new RuntimeException("Bad jsonp!") 
     }

def parsed = new JsonSlurper().parseText(extract.group(1)) 
def filterVersion = parsed.findAll { map -> map.platform == 'Unix' && map.description =~ 'Linux 64'}

FilterVersion.version
