// import React from 'react';
// import ReactDOM from 'react-dom';
//Demo
class Greeting extends React.Component {
    render() {
        const isLoggedIn = this.props.isLoggedIn;
        if(isLoggedIn) {
            return <h1>Welcome User</h1>;
        } else {
            return <h1>Welcome Guest</h1>;
        }
    }
}
ReactDOM.render(<Greeting isLoggedIn = {true}/>, document.getElementById("demo"));
//Element variables
class LogInButton extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (<button onClick = {this.props.onClick}>Log In</button>);
    }
}
class LogOutButton extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (<button onClick = {this.props.onClick}>Log Out</button>);
    }
}
class LoginControl extends React.Component {
    constructor(props) {
        super(props);
        this.handleLogInClick = this.handleLogInClick.bind(this);
        this.handleLogOutClick = this.handleLogOutClick.bind(this);
        this.state = {
            isLoggedIn : false
        };      
    }
    handleLogInClick() {
        this.setState({isLoggedIn:true});
    }
    handleLogOutClick() {
        this.setState({isLoggedIn:false});
    }
    render() {
        const isLoggedIn = this.state.isLoggedIn;
        let button;
        if(isLoggedIn) {
            button = <LogOutButton onClick = {this.handleLogOutClick}/>
        } else {
            button = <LogInButton onClick = {this.handleLogInClick}/>
        }
        return (<div><Greeting isLoggedIn = {isLoggedIn}/>
            {button}
        </div>);
    }
}
ReactDOM.render(<LoginControl/>, document.getElementById("1"));
//Inline if with logical && Operator
class Mailbox extends React.Component {
    render() {
        const unreadMsgs = this.props.unreadMsgs;
        return (<div>
            <h1>Hello</h1>
            {unreadMsgs.length > 0 && 
            <h2>You hanve {unreadMsgs.length} unread messages.</h2>}
        </div>);
    }
}
const msgs = ['React', 'ReactDOM'];
ReactDOM.render(<Mailbox unreadMsgs = {msgs}/>,document.getElementById("2"));
//Inline If - Else with Conditional Operator
class Greeting2 extends React.Component {
    render() {
        const isLoggedIn = this.props.isLoggedIn;
        return (isLoggedIn ? (<h1>Welcome User</h1>) : (<h1>Welcome Guest</h1>));
    }
}
ReactDOM.render(<Greeting2 isLoggedIn = {false}/>, document.getElementById("3"));
//Prevent component from rendering
class WarningBanner extends React.Component {
    render() {
        return (this.props.warn ? (<div className = "warning">Warning!</div>) : null);
    }
}
class Page extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showWarning : true
        }
        this.handleToggleClick = this.handleToggleClick.bind(this);
    }
    handleToggleClick() {
        this.setState(state => ({showWarning : !state.showWarning}));
    }
    render() {
        return (<div>
            <WarningBanner warn = {this.state.showWarning}/>
            <button onClick = {this.handleToggleClick}>{this.state.showWarning ? "Hide" : "Show"}</button>
        </div>);
    }
}
ReactDOM.render(<Page/>, document.getElementById("4"));