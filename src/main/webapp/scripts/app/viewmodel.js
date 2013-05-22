function DocumentHeader(data) {
	this.id = ko.observable(data.id);
    this.title = ko.observable(data.title);
    this.documentType = ko.observable(data.documentType);
    
    this.isDoc = data.documentType == 'doc';
    this.isPdf = data.documentType == 'pdf';
    this.isExcel = data.documentType == 'xls';
}

function Document(data) {
	this.id = ko.observable(data.id);
	this.title = ko.observable(data.title);
	this.notes = ko.observable(data.notes);
	this.modifiedDate = ko.observable(data.modifiedDate);
	this.fileToken = ko.observable(data.fileToken);
	this.tags = ko.observableArray(data.tags);
}

function Tag(data) {
	this.id = ko.observable(data.id);
    this.name = ko.observable(data.name);
}

function DocumentsViewModel() {
    // Data
    var self = this;
    self.documents = ko.observableArray([]);
    self.searchString = ko.observable();
    self.currentDocument = ko.observable();
    /*self.incompleteTasks = ko.computed(function() {
        return ko.utils.arrayFilter(self.tasks(), function(task) { return !task.isDone(); });
    });

    // Operations
    self.addTask = function() {
        self.tasks.push(new Task({ title: this.newTaskText() }));
        self.newTaskText("");
    };
    self.removeTask = function(task) { self.tasks.destroy(task); };
*/
    self.searchDocuments = function() {
    	$.getJSON("/doxtore/rest/documents", {searchString : self.searchString()}, function(allData) {
        var mappedDocuments = $.map(allData, function(item) { return new DocumentHeader(item); });
        self.documents(mappedDocuments);
    	});   
    };
    /*
    // Load initial state from server, convert it to Task instances, then populate self.tasks
    $.getJSON("/doxtore/rest/documents", function(allData) {
        var mappedDocuments = $.map(allData, function(item) { return new DocumentHeader(item); });
        self.documents(mappedDocuments);
    });  
    */
    self.openDocument = function(document) {
        $.getJSON("/doxtore/rest/documents/" + document.id(), function(data) {
        	self.currentDocument(new Document(data));
        });  
    };
    /*
    self.save = function() {
        $.ajax("/knockout/json", {
            data: ko.toJSON(self.tasks),
            type: "post", contentType: "application/json",
            success: function(result) {  },
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
          }
        });
    };*/
}

ko.applyBindings(new DocumentsViewModel());