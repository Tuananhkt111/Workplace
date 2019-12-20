// import React from 'react';
// import ReactDOM from 'react-dom';
//Demo
class Clock extends React.Component {
    render() {
        return(<div>
            <h1 style = {{color: "red"}}>Demo</h1>
            <h2>It is {this.props.date.toLocaleTimeString()}.</h2>
        </div>)
    }
}
function tick() {
    ReactDOM.render(<Clock date = {new Date()}/>, document.getElementById("Demo"));
}
setInterval(tick, 1000);
//Adding local state to a class, life cycle methods
class Clock1 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            date : new Date()
        }
    }
    tick1 = () => (this.setState({date : new Date()}));
    componentDidMount() {
        this.timerID = setInterval(this.tick1, 1000);
    }
    componentWillUnmount() {
        clearInterval(this.timerID);
    }
    render() {
        return(<div>
            <h1 style = {{color: "red"}}>Adding local state to a class, lifecycle methods</h1>
            <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
        </div>)
    }
}
ReactDOM.render(<Clock1/>, document.getElementById("1"));
//Data flows down
class App extends React.Component {
    render() {
        return(<div>
            <Clock1/>
            <Clock1/>
            <Clock1/>
            <Clock1/>
        </div>)
    }
}
ReactDOM.render(<App/>, document.getElementById("2"));



