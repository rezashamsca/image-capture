'use strict'

const https = require('https')
const http = require('http')

function performRequest(protocol, host, port, endpoint, method, data, success) {
    var dataString = JSON.stringify(data);
    var headers = {};
    
    if (method == 'GET') {
      endpoint += '?' + querystring.stringify(data);
    }
    else {
      headers = {
        'Content-Type': 'application/json',
        'Content-Length': dataString.length
      };
    }

    try {
      var options = {
        host: host,
        port: port,
        path: endpoint,
        method: method,
        headers: headers
      };
    
      var httpClient;
      if (protocol == 'https') {
        httpClient = https;
      }
      else {
        httpClient = http;
      }
      var req = httpClient.request(options, function(res) {
        res.setEncoding('utf-8');
    
        var responseString = '';
    
        res.on('data', function(data) {
          responseString += data;
        });
    
        res.on('end', function() {
          console.log(responseString);
          if (('' + res.statusCode).match(/^2\d\d$/)) {
            var responseObject = JSON.parse(responseString);
            success(responseObject);
          }
        });
      });

      req.on('error', function(e) {
        console.log(e)
      });
    }
    catch (err) {
        console.log(err)
    }
  
    req.write(dataString);
    req.end();
  };

  module.exports = performRequest;