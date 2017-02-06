const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {places: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/place'}).done(response => {
            this.setState({places: response.entity._embedded.places});
        });
    }

    render() {
        return (
            <PlaceList employees={this.state.places}/>
        )
    }
}

class PlaceList extends React.Component {
    render() {
        var places = this.props.places.map(place =>
            <Employee key={place._links.self.href} place={place}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Longtitude</th>
                    <th>Latitude</th>
                    <th>Address</th>
                </tr>
                {places}
                </tbody>
            </table>
        )
    }
}

class Place extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.place.id}</td>
                <td>{this.props.place.name}</td>
                <td>{this.props.place.longtitude}</td>
                <td>{this.props.place.latitude}</td>
                <td>{this.props.place.address}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)