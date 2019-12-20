// import React from 'react';
// import ReactDOM from 'react-dom';
class BoilingVerdict extends React.Component {
    render() {
        return (this.props.celsius >= 100 ? (<p>
            The water would boil.
        </p>) : (<p>
            The water would not boil.
        </p>));
    }
}
class Calculator extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            temperature : ""
        }
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(event) {
        this.setState({temperature : event.target.value})
    }
    render() {
        const temperature = this.state.temperature;
        return(<fieldset>
                <legend>Enter temperature Celsius:</legend>
                <input value={temperature} onChange={this.handleChange}/>
                <BoilingVerdict celsius={parseFloat(temperature)}/>            
        </fieldset>)
    }
}
ReactDOM.render(<Calculator/>, document.getElementById("demo"));
//Adding a Second Input
const scaleNames = {
    c: "Celsius",
    f: "Fahrenheit"
}
class TemperatureInput extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.state = {
            temperature : ""
        }
    }
    handleChange(event) {
        this.setState({temperature : event.target.value});
    }
    render() {
        const temperature = this.state.temperature;
        const scaleName = this.props.scale;
        return (<fieldset>
            <legend>
                Enter temperature in {scaleNames[scaleName]}:
            </legend>
            <input value={temperature} onChange={this.handleChange} />
        </fieldset>)
    }
}
class Calculator2 extends React.Component {
    render() {
        return (<div>
            <TemperatureInput scale="c"/>
            <TemperatureInput scale="f"/>
        </div>)
    }
}
ReactDOM.render(<Calculator2 />, document.getElementById("1"));
//Writing Conversion Functions
function toCelsius(fahrenheit) {
    return (fahrenheit - 32)* 5 / 9;
}
function toFahrenheit(celsius) {
    return (celsius * 9 /5) + 32;
}
function tryConvert(temperature, convert) {
    const input = parseFloat(temperature);
    if(Number.isNaN(input)) {
        return "";
    } else {
        const output = convert(input);
        const rounded = Math.round(output * 1000) / 1000;
        return rounded.toString();
    }
}
//Lifting State Up
class TemperatureInput2 extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(event) {
        this.props.onTemperatureChange(event.target.value);
    }
    render() {
        const temperature = this.props.temperature;
        const scaleName = this.props.scale;
        return (<fieldset>
            <legend>Enter temperature in {scaleNames[scaleName]}:</legend>
            <input value={temperature} onChange={this.handleChange}/>
        </fieldset>)
    }
}
class Calculator3 extends React.Component {
    constructor(props) {
        super(props);
        this.handleFahrenheitChange = this.handleFahrenheitChange.bind(this);
        this.handleCelsiusChange = this.handleCelsiusChange.bind(this);
        this.state = {
            temperature : "", scale : "c"
        }
    }
    handleFahrenheitChange(temperature) {
        this.setState({scale : "f", temperature});
    }
    
    handleCelsiusChange(temperature) {
        this.setState({scale : "c", temperature});
    }
    render() {
        const scale = this.state.scale;
        const temperature = this.state.temperature;
        const celsius = scale === "f" ? tryConvert(temperature, toCelsius) : temperature;
        const fahrenheit = scale === "c" ? tryConvert(temperature, toFahrenheit) : temperature;
        return (<div>
            <TemperatureInput2 temperature={celsius} onTemperatureChange={this.handleCelsiusChange} scale="c"/>
            <TemperatureInput2 temperature={fahrenheit} onTemperatureChange={this.handleFahrenheitChange} scale="f"/>
            <BoilingVerdict celsius={celsius}/>
        </div>)
    }
}
ReactDOM.render(<Calculator3/>, document.getElementById("2"));