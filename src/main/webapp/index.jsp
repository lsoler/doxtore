<html>
<head>

<link href="static/css/doxtore.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>Documents</h3>

<div class="searchBox">
	<form data-bind="submit: searchDocuments">
	    <input data-bind="value: searchString"/>
	    <button type="submit">Search</button>
	</form>
</div>

<div class="documentsListContainer">
	<ul data-bind="foreach: documents, visible: documents().length > 0" class="documentList">
	    <li>
	    	<span data-bind="css: { docIconWord : isDoc, docIconPdf : isPdf, docIconExcel : isExcel } "></span>      
			<span data-bind="text: title"></span>
	    </li> 
	</ul>
</div>
<!-- 

<form data-bind="submit: addTask">
    Add task: <input data-bind="value: newTaskText" placeholder="What needs to be done?" />
    <button type="submit">Add</button>
</form>
<ul data-bind="foreach: tasks, visible: tasks().length > 0">
    <li>
        <input type="checkbox" data-bind="checked: isDone" />
        <input data-bind="value: title, disable: isDone" />
        <a href="#" data-bind="click: $parent.removeTask">Delete</a>
    </li> 
</ul>



You have <b data-bind="text: incompleteTasks().length">&nbsp;</b> incomplete task(s)
<span data-bind="visible: incompleteTasks().length == 0"> - it's beer time!</span>

<button data-bind="click: save">Save</button>
  -->
<form name="uploadForm" enctype="multipart/form-data">
  <input name="uploadInput" name="file" type="file" />
  <input id="uploadBtn" type="button" value="Upload" />
</form>

<progress></progress>


<script src="scripts/lib/jquery-1.9.1.min.js" type="text/javascript"></script>
<script>
$('#uploadBtn').click(function(){
    var formData = new FormData();
    formData.append("File", document.uploadForm.uploadInput.files[0]);
    //var formData = document.getElementById('uploadInput').files[0];
    $.ajax({
        url: '/knockout/file',  //server script to process data
        type: 'POST',
        xhr: function() {  // custom xhr
            var myXhr = $.ajaxSettings.xhr();
            if(myXhr.upload){ // check if upload property exists
                myXhr.upload.addEventListener('progress',progressHandlingFunction, false); // for handling the progress of the upload
            }
            return myXhr;
        },
        //Ajax events
        //beforeSend: beforeSendHandler,
        success: completeHandler,
        //error: errorHandler,
        // Form data
        data: formData,
        //Options to tell JQuery not to process data or worry about content-type
        cache: false,
        contentType: false,
        processData: false
    });
});

function progressHandlingFunction(e){
    if(e.lengthComputable){
        $('progress').attr({value:e.loaded,max:e.total});
    }
}

function completeHandler(e){
	alert(e);
}
</script>


<script src="scripts/lib/knockout-2.2.1.js" type="text/javascript"></script>
<script src="scripts/app/viewmodel.js" type="text/javascript"></script>
</html>
