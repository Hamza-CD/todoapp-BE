var User = Backbone.Model.extend({
    urlRoot: 'http://localhost:8080/todo_application/users'
});

var ToDoItem = Backbone.Model.extend({
    urlRoot: 'http://localhost:8080/todo_application/todoitems'
});

var ToDoItemList = Backbone.Collection.extend({
    model: ToDoItem,
    url: 'http://localhost:8080/todo_application/todoitems'
});
