import React from 'react';

class SearchInput extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        this.props.handleChange(e.target.value);
    }

    render() {
        return (
            <input type="text" value={this.props.value} onChange={this.handleChange} 
                    style={{position: 'relative', height: '20px', fontSize: '20px', borderRadius: '5px'}}
                    placeholder="Search here" />
        );
    }
}

export default SearchInput;