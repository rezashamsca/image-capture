// Grab elements, create settings, etc.
var video = document.getElementById('video');

// Get access to the camera!
if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
    // Not adding `{ audio: true }` since we only want video now
    navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
        video.src = window.URL.createObjectURL(stream);
        video.play();
    });
}

// Elements for taking the snapshot
var canvas = document.getElementById('canvas');
var context = canvas.getContext('2d');
var video = document.getElementById('video');

// Trigger photo take
document.getElementById("snap").addEventListener("click", function() {
	context.drawImage(video, 0, 0, 640, 480);
});

// Trigger upload to server
document.getElementById("upload").addEventListener("click", function() {
    // upload to server
    // sendImageInBase64();
    sendImageInBase64();
});

function sendImageInBase64() {
    var canvas = document.getElementById('canvas');
    var dataURL = canvas.toDataURL("image/jpeg");
    var base64Image = dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
    var imageData = JSON.stringify(base64Image);
    $.ajax({
        url: 'http://localhost:3000/image',
        dataType: 'json',
        data: imageData,
        type: 'POST',
        success: function (data) {
            console.log(data);
        },
        error: function (e) {
            console.log(e);
        }
    });
}

function sendImageInBinary() {
    var canvas = document.getElementById('canvas');
    var dataURL = canvas.toDataURL("image/jpeg");
    var blobBin = atob(dataURL.split(',')[1]);
    var array = [];
    for(var i = 0; i < blobBin.length; i++) {
        array.push(blobBin.charCodeAt(i));
    }
    var file=new Blob([new Uint8Array(array)], {type: 'image/jpg'});
    var formData = new FormData();
    formData.append("file_name_1234.jpg", file);
    $.ajax({
        url: 'http://localhost:3000/image',
        data: formData,
        type: 'POST',
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data);
        },
        error: function (e) {
            console.log(e);
        }
    });
}
