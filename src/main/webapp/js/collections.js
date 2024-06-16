// js/collections.js
var Users = Backbone.Collection.extend({
    model: User,
    url: '/todo_application/users'
});

var ToDoItems = Backbone.Collection.extend({
    model: ToDoItem,
    url: '/todo_application/todoitems'
});
