const express = require('express')
const app = express()
const path = require('path')

// app.use(express.static(__dirname + '/view'));
//app.use(express.static(path.join(__dirname, 'public')));
//app.use("/view", express.static(path.join(__dirname, 'view')));
//app.use("/script", express.static(path.join(__dirname, 'script')));
app.use("/script", express.static(path.join(__dirname, 'script')));
app.use("/stylesheet", express.static(path.join(__dirname, 'stylesheet')));

app.get('/', (req, res) => res.sendFile(path.join(__dirname, 'view/capture.html')));

app.listen(3000, () => console.log('Example app listening on port 3000!'))