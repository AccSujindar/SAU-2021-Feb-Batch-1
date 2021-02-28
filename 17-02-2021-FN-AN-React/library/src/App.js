import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';

import Library from './containers/Library/Library';

class App extends Component {
  render () {
    return (
      <BrowserRouter>
        <div className="App">
          <Library/>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
