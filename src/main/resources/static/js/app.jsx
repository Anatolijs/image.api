import React from 'react';
import ReactDOM from 'react-dom';

 // const React = require('react');
 // const client = require('./client');

const App = React.createClass ({

    getInitialState: function () {
        return {images: []};
    },
    componentDidMount: function () {
        client({method: 'GET', path: '/api/images'}).done(response => {
            this.setState({images: response.entity._embedded.images});
        });
    },
    render: function () {
        return (
            <ImageList images={this.state.images}/>
        );
    }
});
//export default App;

class ImageList extends React.Component{
    constructor(props) {
        super(props);
    }
    render: function () {
        const images = this.props.images.map(image => <Image key={image._links.self.href} image={image} />
    );
        return (
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Location</th>
                </tr>
                {images}
            </table>
        );
    }
}
//export default ImageList;

class Image extends React.Component{
    constructor(props) {
        super(props);
    }
    render: function () {
        return (
            <tr>
                <td>{this.props.image.id}</td>
                <td>{this.props.image.name}</td>
                <td>{this.props.image.location}</td>
            </tr>
        );
    }
}
//export default Image;

ReactDOM.render(<App />, document.getElementById('app'));