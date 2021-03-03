import React, { Component } from 'react';
import Book from '../../../components/Book/Book';
import './Books.css';


class Books extends Component {

    state = {
        search: '',
        books: []
    }
    componentDidMount()
    {
        this.loadData('');
    }
    componentDidUpdate () {

    }

    loadData = (searchValue) => {
        let newBooks = this.props.getBooks(searchValue);
        this.setState({
            books: newBooks
        });
        this.setState({search: searchValue})
    }

    bookSelectedHandler = (id) => {
        this.props.history.push( '/books/' + id );
    }

    searchChangeHandler = (event) => {
        this.loadData(event.target.value);        
    }
    
    render () {
        console.log(this.props);
       
        let books = this.state.books.map((book,idx) => {
            return <Book 
                key={book.idx} 
                title={book.title} 
                author={book.author}
                clicked={() => this.bookSelectedHandler(idx)} />;
        });
        

        return (
            <div>
                <input className="Search" type="text" value={this.state.search} onChange={(event) => this.searchChangeHandler(event)}
                placeholder="Search by Title" />
                <section className="Books">
                    {books}
                </section>
            </div>
        );
    }
}

export default Books;