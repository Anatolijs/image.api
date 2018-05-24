import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Image from './Image';
import SearchInput from './SearchInput';

class App extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.state = {images: [], selectedImage: null, searchValue: ''};
  
  }


  handleClick(idx) {
    this.setState({selectedImage: this.state.images[idx]});
  }

  handleChange(searchValue) {
    this.setState({ searchValue });
  }

  componentDidMount() {
    fetch('http://localhost:8090/app/images')
    .then(response => response.json())
    .then(images => this.setState({ images }));
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">React Image Preview</h1>
        </header>
        <SearchInput handleChange={this.handleChange} value={this.state.searchValue}/>
        <div>
          {this.state.images
            .filter(image => image.tags.some(tag => tag.startsWith(this.state.searchValue)))
            .map((image, idx) => <Image {...image} key={image.id} handleClick={() => this.handleClick(idx)}/>)}
        </div>
        <div style={{position: 'fixed', maxWidth: '400px', top: '250px'}}>
          {
            this.state.selectedImage && <img src={`http://localhost:8090/app/images/image/${this.state.selectedImage.id}/png`} />
          }
        </div>
      </div>
    );
  }
}

export default App;
