// import React from 'react';
// import ReactDOM from 'react-dom';
// Controlled component     
class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { name: "" };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        this.setState({ name: event.target.value.toUpperCase() })
    }
    handleSubmit(event) {
        event.preventDefault();
        alert("A name was submitted: " + this.state.name);
    }
    render() {
        return (<form onSubmit={this.handleSubmit}>
            <label>Name: <input type="text" value={this.state.name} onChange={this.handleChange} /></label>
            <input type="submit" value="Submit" />
        </form>);
    }
}
ReactDOM.render(<NameForm />, document.getElementById("1"));
//The Textarea tag
class EssayForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: "Please write an essay about your favorite DOM element." };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        this.setState({ value: event.target.value });
    }
    handleSubmit(event) {
        event.preventDefault();
        alert("An essay was submitted: " + this.state.value);
    }
    render() {
        return (<form onSubmit={this.handleSubmit}>
            <label>Essay:</label>
            <textarea value={this.state.value} onChange={this.handleChange} />
            <input type="submit" value="submit" />
        </form>);
    }
}
ReactDOM.render(<EssayForm />, document.getElementById("2"));
//The Select Tag
class FlavorForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: "coconut" };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        this.setState({ value: event.target.value });
    }
    handleSubmit(event) {
        event.preventDefault();
        alert("Your favorite flavor: " + this.state.value);
    }
    render() {
        return (<form onSubmit={this.handleSubmit}>
            <label>Pick your favorite flavor:</label>
            <select value={this.state.value} onChange={this.handleChange}>
                <option value="grapefruit">Grapefruit</option>
                <option value="lime">Lime</option>
                <option value="coconut">Coconut</option>
                <option value="mango">Mango</option>
            </select>
            <input type="submit" value="submit" />
        </form>);
    }
}
ReactDOM.render(<FlavorForm />, document.getElementById("3"));
//The Select Tag Multiple
class FlavorForm2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: "coconut" };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        const options = event.target.options;
        var values = [];
        for (var i = 0; i < options.length; i++) {
            if (options[i].selected) {
                values.push(options[i].value);
            }
        }
        this.setState({ value: values });
    }
    handleSubmit(event) {
        event.preventDefault();
        alert("Your favorite flavor: " + this.state.value);
    }
    render() {
        return (<form onSubmit={this.handleSubmit}>
            <label>Pick your favorite flavor:</label>
            <select value={this.state.value} onChange={this.handleChange} multiple={true}>
                <option value="grapefruit">Grapefruit</option>
                <option value="lime">Lime</option>
                <option value="coconut">Coconut</option>
                <option value="mango">Mango</option>
            </select>
            <input type="submit" value="submit" />
        </form>);
    }
}
ReactDOM.render(<FlavorForm2 />, document.getElementById("4"));
//The File Inputs: uncontrolled
//Handling Multiple Inputs
class Reservation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isGoing: true,
            numberOfGuests: 2,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }
    handleInputChange(event) {
        const target = event.target;
        const value = target.type === "checkbox" ? target.checked : target.value;
        const name = target.name;
        this.setState({ [name]: value });
    }
    render() {
        return (<form>
            <label>Is going:
                <input type="checkbox" name="isGoing" onChange={this.handleInputChange} checked={this.state.isGoing} />
            </label>
            <br></br>
            <label>Number of guests: 
                <input name="numberOfGuests" type="number" value={this.state.numberOfGuests} onChange={this.handleInputChange}/>
            </label>
        </form>)
    }
}
ReactDOM.render(<Reservation/>,document.getElementById("5"));
