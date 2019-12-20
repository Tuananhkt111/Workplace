// import React from 'react';
// import ReactDOM from 'react-dom';
//Demo
// Demo 1
class Toggle1 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick() {
        this.setState(state => ({isToggleOn: !state.isToggleOn}));
    }
    render() {
        return (<button onClick = {this.handleClick}>
            {this.state.isToggleOn ? "ON" : "OFF"}
        </button>);
    }
}
ReactDOM.render(<Toggle1/>, document.getElementById("demo1"));
// Demo 2: different callback is created each time it renders
class Toggle2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };
    }
    handleClick() {
        this.setState(state => ({isToggleOn: !state.isToggleOn}));
    }
    render() {
        return (<button onClick = {() => this.handleClick()}>
            {this.state.isToggleOn ? "ON" : "OFF"}
        </button>);
    }
}
ReactDOM.render(<Toggle2/>, document.getElementById("demo2"));
// Demo 3
class Toggle3 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };
    }
    handleClick() {
        this.setState(state => ({isToggleOn: !state.isToggleOn}));
    }
    render() {
        return (<button onClick = {this.handleClick.bind(this)}>
            {this.state.isToggleOn ? "ON" : "OFF"}
        </button>);
    }
}
ReactDOM.render(<Toggle3/>, document.getElementById("demo3"));
// Demo 4: This is experiental syntax
class Toggle4 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };
    }
    handleClick = () => {
        this.setState(state => ({isToggleOn: !state.isToggleOn}));
    }
    render() {
        return (<button onClick = {this.handleClick}>
            {this.state.isToggleOn ? "ON" : "OFF"}
        </button>);
    }
}
ReactDOM.render(<Toggle4/>, document.getElementById("demo4"));
