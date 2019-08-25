var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var orderSchema =  new Schema({
	id: Number,
	amount: Number,
	account: Number,
	description: String,
	transaction_type: Number,
	ticket_id: Number
}); 

mongoose.connect('mongodb://mongo:27017/test', {useNewUrlParser: true});
module.exports = mongoose.model('Transaction', orderSchema);
