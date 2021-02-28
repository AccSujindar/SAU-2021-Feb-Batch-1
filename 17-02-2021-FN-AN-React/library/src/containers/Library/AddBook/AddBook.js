import React, { Component } from 'react';
import './AddBook.css';

class AddBook extends Component {
    state = {
        title: '',
        content: '',
        author: '',
    }
    componentDidMount () {
    }

    bookDataHandler = () => {

        const Book = {
            title: this.state.title,
            body: this.state.content,
            author: this.state.author
        };
        this.props.addBook(Book);
        this.props.history.push('/books');
    }

    render () {
        return (
            <div className="AddBook">
                <h1>Add Book</h1>
                <label>Title</label>
                <input type="text" value={this.state.title} onChange={(event) => this.setState({title: event.target.value})} />
                <label>Content</label>
                <textarea rows="4" value={this.state.content} onChange={(event) => this.setState({content: event.target.value})} />
                <label>Author</label>
                <input type="text" value={this.state.author} onChange={(event) => this.setState({author: event.target.value})} />
                <button onClick={this.bookDataHandler}>Add Book</button>
            </div>
        );
    }
}

export default AddBook;