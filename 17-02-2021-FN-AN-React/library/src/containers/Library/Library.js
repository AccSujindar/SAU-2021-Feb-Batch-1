import React, { Component } from 'react';
import { Route, NavLink, Switch , Redirect} from 'react-router-dom';

import './Library.css';
import Books from './Books/Books';
import AddBook from './AddBook/AddBook';
import ViewBook from './ViewBook/ViewBook'
class Library extends Component {

    state = {
        Books:[]
    }
    addBookHandler = (newBook) => {
        const newBooks = [
            ...this.state.Books,
            newBook
        ];
        this.setState({
            Books: newBooks
        });
    }

    deleteBookHandler = (idx) => {
        const newBooks = [
            ...this.state.Books
        ];
        newBooks.splice(idx,1);
        this.setState({
            Books: newBooks
        });
    }

    getBooksHandler = (search) => {
        if(search === '')
            return this.state.Books;
        else
        {
            let pattern = new RegExp("\\b"+search);
            let newBooks = this.state.Books.filter((book) => {
                return pattern.test(book.title);
            })
            return newBooks;
        }
    }

    getBookHandler = (idx) => {
        return this.state.Books[idx];
    }

    render () {
        return (
            <div className="Library">
                <header>
                    <nav>
                        <ul>
                            <li><NavLink
                                to="/books/"
                                exact
                                >Home</NavLink></li>
                            <li><NavLink to={{
                                pathname: '/add-book',
                            }}>Add Book</NavLink></li>
                        </ul>
                    </nav>
                </header>
                <Switch>
                    <Route path="/add-book" render={(props) => <AddBook {...props} addBook={this.addBookHandler}/>} />
                    <Route path={'/books/:id'} render={(props) => <ViewBook {...props} getBook={this.getBookHandler} deleteBook={this.deleteBookHandler}/>} />
                    <Route path="/books" render={(props) => <Books {...props} getBooks={this.getBooksHandler} getBook={this.getBookHandler} />} />
                    <Route path="/" exact><Redirect to="/add-book" /></Route>
                    <Route render={() => <h1>Not found</h1>}/>
                </Switch>
            </div>
        );
    }
}

export default Library;