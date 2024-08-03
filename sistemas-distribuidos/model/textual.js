const mongoose = require ('mongoose');
mongoose.Promise = global.Promise;

const modelSchema = new mongoose.Schema ({
    name:String,
    funcao:String,
    cpf:String,
    departamento:String,

    status:{type:Boolean, default: true}
});

const modelName = 'Textual';

if(mongoose.connection && mongoose.connection.models[modelName]) {
    module.exports = mongoose.connection.models[modelName]
} else {
    module.exports = mongoose.connection.model(modelName, modelSchema);
}