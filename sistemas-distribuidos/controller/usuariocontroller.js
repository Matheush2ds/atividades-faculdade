const Usuario = require('../model/usuario');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addUsuario: async (req, res) => {
        const erros = validationResult(req);

        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });

            return;
        }

        const data = matchedData(req);

        const novoUsuario = new Usuario();
        novoUsuario.nome = data.nome;
        novoUsuario.email = data.email;
        novoUsuario.senha = data.senha;
        novoUsuario.telefone = data.telefone;
        novoUsuario.cep = data.cep;

        const info = await novoUsuario.save();
        res.json({ info });
    },

    getUsuarios: async (req, res) => {
        try {
            const usuarios = await Usuario.find();
            res.json(usuarios);
        } catch (error) {
            res.json({ error: 'Erro ao buscar usuários!' });
        }
    },

    deleteUsuario: async (req, res) => {
        const usuarioId = req.params.id;

        try {
            const deletedUsuario = await Usuario.findByIdAndDelete(usuarioId);

            if (!deletedUsuario) {
                res.json({ error: 'Usuário não encontrado!' });
                return;
            }

            res.json({ message: 'Usuário excluído com sucesso!' });
        } catch (error) {
            res.json({ error: 'Erro ao excluir usuário!' });
        }
    },

    editUsuario: async (req, res) => {
        const usuarioId = req.params.id;
        const erros = validationResult(req);

        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });
            return;
        }

        const data = matchedData(req);

        try {
            const updatedUsuario = await Usuario.findByIdAndUpdate(usuarioId, data, { new: true });
            if (!updatedUsuario) {
                res.json({ error: 'Usuário não encontrado!' });
                return;
            }
            res.json({ updatedUsuario });
        } catch (error) {
            res.json({ error: 'Erro ao editar usuário!' });
        }
    }
};
