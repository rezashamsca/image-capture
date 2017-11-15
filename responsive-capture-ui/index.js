const express = require('express')
const app = express()
const path = require('path')
const callService = require('./script/callService')
const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({
    extended: true
  }));

// app.use(express.static(__dirname + '/view'));
//app.use(express.static(path.join(__dirname, 'public')));
//app.use("/view", express.static(path.join(__dirname, 'view')));
//app.use("/script", express.static(path.join(__dirname, 'script')));
app.use("/script", express.static(path.join(__dirname, 'script')));
app.use("/stylesheet", express.static(path.join(__dirname, 'stylesheet')));

app.get('/', (req, res) => res.sendFile(path.join(__dirname, 'view/capture.html')));

app.post('/image', (req, res) => {
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:8080');
    res.setHeader('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    callService('http://localhost:8080/image', 'POST', req.body, function(responseObj) {
        res.send(responseObj);
    })
})

app.listen(3000, () => console.log('Example app listening on port 3000!'))