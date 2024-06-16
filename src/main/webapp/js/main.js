// Define your Backbone.js router
var AppRouter = Backbone.Router.extend({
    routes: {
        '': 'home',
        'add': 'addTodo'
    },

    home: function () {
        var todoList = new ToDoList();
        var todoListView = new ToDoListView({ collection: todoList });
        todoList.fetch(); // Fetch data from the backend
        $('#todoList').html(todoListView.render().el);
    },

    addTodo: function () {
        var todo = new ToDoItem();
        var addTodoView = new AddToDoView({ model: todo });
        $('#todoList').html(addTodoView.render().el);
    }
});

// Initialize the application
$(function () {
    var appRouter = new AppRouter();
    Backbone.history.start();
});
