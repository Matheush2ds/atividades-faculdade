const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const usuarioSchema = new mongoose.Schema({
    nome: String,
    email: String,
    senha: String,
    telefone: String,
    cep: String,
    status: { type: Boolean, default: true }
});

const modelName = 'Usuario';

if (mongoose.connection && mongoose.connection.models[modelName]) {
    module.exports = mongoose.connection.models[modelName];
} else {
    module.exports = mongoose.model(modelName, usuarioSchema);
}
