// import React from 'react';
// import ReactDOM from 'react-dom';
//Rendering multiple compopnents
const numbers = [1, 2, 3, 4, 5];
const listItems = numbers.map((num) => <li>{num}</li>);
ReactDOM.render(<ul>{listItems}</ul>, document.getElementById("1"));
//Basic list component
class NumberList extends React.Component {
    render() {
        const numbers = this.props.numbers;
        const listItems = numbers.map(number =>
            (<li key={number.toString()}>{number}</li>));
        return (<ul>{listItems}</ul>);
    }
}
const number = [1, 2, 3, 4, 5];
ReactDOM.render(<NumberList numbers={number} />, document.getElementById("2"));
//Keys & Extracting Components with Keys
class ListItem extends React.Component {
    render() {
        return (<li>{this.props.value}</li>);
    }
}
class NumberList2 extends React.Component {
    render() {
        const listItems = this.props.numbers.map(number =>
            (<ListItem key={number.toString()} value={number} />));
        return (<ul>{listItems}</ul>);
    }
}
const numbers2 = [1, 2, 3, 4, 5, 6];
ReactDOM.render(<NumberList2 numbers={numbers2} />, document.getElementById("2"));
//Embedding map() in JSX
class NumberList3 extends React.Component {
    render() {
        return (<ul>
            {this.props.numbers.map(number =>
                (<ListItem key={number.toString()} value={number} />)
            )}
        </ul>
        );
    }
}
ReactDOM.render(<NumberList3 numbers={numbers2} />, document.getElementById("3"));

