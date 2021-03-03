import React, { Component } from 'react';
import './ViewBook.css';

class ViewBook extends Component {
    state = {
        loadedBook: null
    }
    componentDidMount () {
        this.loadData();
    }
    loadData () {

        if (  this.props.match.params.id ) {
            if ( !this.state.loadedBook || (this.state.loadedBook && this.state.loadedBook.id !== + this.props.match.params.id) ) {
                let newBook = this.props.getBook(this.props.match.params.id);
                this.setState({
                    loadedBook: newBook
                });
            }
        }
    }
    deleteBookHandler = () => {
        this.props.deleteBook(this.props.match.params.id);
        this.props.history.push('/books');
    }

    render () {
        let book = <p style={{ textAlign: 'center' }}>Please select a Book!</p>;
        if ( this.props.match.params.id ) {
            book = <p style={{ textAlign: 'center' }}>Loading...!</p>;
        }
        if ( this.state.loadedBook ) {
            book = (
                <div className="ViewBook">
                    <h1>{this.state.loadedBook.title}</h1>
                    <p>{this.state.loadedBook.body}</p>
                    <h4>By {this.state.loadedBook.author}</h4>
                    <div className="Edit">
                        <button onClick={this.deleteBookHandler} className="Delete">Delete</button>
                    </div>
                </div>
            );
        }
        return book;
    }
}

export default ViewBook;