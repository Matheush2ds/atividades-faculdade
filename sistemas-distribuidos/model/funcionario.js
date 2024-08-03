const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const funcionarioSchema = new mongoose.Schema({
    nome: String,
    sobrenome: String,
    cargo: String,
    salario: Number,
    cpf: String,
    status: { type: Boolean, default: true }
});

const modelName = 'Funcionario';

if (mongoose.connection && mongoose.connection.models[modelName]) {
    module.exports = mongoose.connection.models[modelName];
} else {
    module.exports = mongoose.model(modelName, funcionarioSchema);
}
