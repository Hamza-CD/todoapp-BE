// Define your template
var todoItemTemplate = _.template(`
    <div class="todo-item">
        <h3><%= title %></h3>
        <p><%= description %></p>
        <button class="delete-btn">Delete</button>
        <button class="update-btn">Update</button>
    </div>
`);

// Define your view
var TodoItemView = Backbone.View.extend({
    template: todoItemTemplate,

    initialize: function() {
        this.listenTo(this.model, 'change', this.render);
        this.render();
    },

    render: function() {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});
