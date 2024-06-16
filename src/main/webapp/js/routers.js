var AppRouter = Backbone.Router.extend({
    routes: {
        '': 'home'
    },

    home: function() {
        var todoItem = new ToDoItem();
        var todoItemView = new TodoItemView({ model: todoItem, el: '#todo-list' });
    }
});

var appRouter = new AppRouter();

Backbone.history.start();
