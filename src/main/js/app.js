'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {customers: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/customers'}).done(response => {
			this.setState({customers: response.entity._embedded.customers});
		});
	}

	render() {
		return (
			<CustomerList customers={this.state.customers}/>
		)
	}
}

class CustomerList extends React.Component{
	render() {
		var customers = this.props.customers.map(customer =>
			<Customer key={customer._links.self.href} customer={customer}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Login</th>
					</tr>
					{customers}
				</tbody>
			</table>
		)
	}
}

class Customer extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.customer.firstName}</td>
				<td>{this.props.customer.lastName}</td>
				<td>{this.props.customer.login}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)