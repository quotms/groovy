#!/usr/bin/env groovy
import groovy.json.JsonSlurper 

def addr       = "https://registry:5001/v2/list" 
def authString = "xxxxxxx==" 
def conn = addr.toURL().openConnection() 

conn.setRequestProperty( "Authorization", "Basic ${authString}" ) 

if( conn.responseCode == 200 ) { 
  def inputJSON = new JsonSlurper().parse(conn.content) 
  assert inputJSON instanceof Map 
  inputJSON.tags.reverse() 
} else { 
  return["error"] 
} 
