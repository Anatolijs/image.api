import React from 'react';
import Image from 'react-image-resizer';

export default ({name, handleClick, id}) => (
    <div>
        <p>{name}</p>
        <img src={`http://localhost:8090/app/images/image/${id}/png`} onClick={handleClick} responsive/>
    </div>
);


