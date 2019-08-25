var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var orderSchema =  new Schema({
	operation_id: Number,
	operation_type: Number
}); 

module.exports = mongoose.model('Tickets', orderSchema);
