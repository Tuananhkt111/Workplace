// import React from 'react';
// import ReactDOM from 'react-dom';
//1. Function and class components
//a. Class component
class AppA extends React.Component {
    render() {
        return (<h1>Hello {this.props.name}</h1>);
    }
}
ReactDOM.render(<AppA name = "Function component"/>, document.getElementById('1.a'));
//b. Function component
function AppB(props) {
    return (<h1>Hello {props.name}</h1>);
}
ReactDOM.render(<AppB name = "Class component"/>, document.getElementById('1.b'));
//2. Composing component
class Compo extends React.Component {
    render() {
        return(<div>
            <AppA name = "Composing component 1"/>
            <AppA name = "Composing component 2"/>
            <AppA name = "Composing component 3"/>
        </div>)
    }
}
ReactDOM.render(<Compo/>, document.getElementById("2"))