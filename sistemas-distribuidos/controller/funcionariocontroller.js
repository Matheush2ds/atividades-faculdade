const Funcionario = require('../model/funcionario');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addFuncionario: async (req, res) => {
        const erros = validationResult(req);

        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });

            return;
        }

        const data = matchedData(req);

        const novoFuncionario = new Funcionario();
        novoFuncionario.nome = data.nome;
        novoFuncionario.sobrenome = data.sobrenome;
        novoFuncionario.cargo = data.cargo;
        novoFuncionario.salario = data.salario;
        novoFuncionario.cpf = data.cpf;

        const info = await novoFuncionario.save();
        res.json({ info });
    },

    getFuncionario: async (req, res) => {
        let nome = req.query.nome;
        const funcionario = await Funcionario.find({ nome: nome });

        if (!funcionario || funcionario.length === 0) {
            res.json({ res: 'Funcionário não encontrado!' });
            return;
        }

        res.json({ funcionario });
    },

    getAllFuncionarios: async (req, res) => {
        try {
            const funcionarios = await Funcionario.find();
            res.json(funcionarios);
        } catch (error) {
            res.json({ error: 'Erro ao buscar funcionários!' });
        }
    },

    deleteFuncionario: async (req, res) => {
        const funcionarioId = req.params.id;

        try {
            const deletedFuncionario = await Funcionario.findByIdAndDelete(funcionarioId);

            if (!deletedFuncionario) {
                res.json({ error: 'Funcionário não encontrado!' });
                return;
            }

            res.json({ message: 'Funcionário excluído com sucesso!' });
        } catch (error) {
            res.json({ error: 'Erro ao excluir funcionário!' });
        }
    },

    editFuncionario: async (req, res) => {
        const funcionarioId = req.params.id;
        const erros = validationResult(req);

        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });
            return;
        }

        const data = matchedData(req);

        try {
            const updatedFuncionario = await Funcionario.findByIdAndUpdate(funcionarioId, data, { new: true });
            if (!updatedFuncionario) {
                res.json({ error: 'Funcionário não encontrado!' });
                return;
            }
            res.json({ updatedFuncionario });
        } catch (error) {
            res.json({ error: 'Erro ao editar funcionário!' });
        }
    }
};
