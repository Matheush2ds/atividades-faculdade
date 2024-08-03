const Textual = require('../model/textual')
const { validationResult, matchedData } = require('express-validator')

module.exports = {
    addTextual: async(req, res) => {
        const erros = validationResult(req)

        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            })

            return
        }

        const data = matchedData(req)

        const newTextual = new Textual()
        newTextual.name = data.name
        newTextual.createdAt = Date.now()
        newTextual.title = data.title
        newTextual.text = data.text
        newTextual.fontsize = data.fontsize

        const info = await newTextual.save()
        res.json({ info })
    },

    getTextual: async(req, res) => {
        let name = req.query.name
        const nameTextual = await Textual.find({ name: name })

        if (nameTextual == null) {
            res.json({ res: 'Nome do textual não encontrado!' })
             
            return
        }

        res.json({ nameTextual })
    },
    
    getAllTextuals: async (req, res) => {
        try {
            const textuals = await Textual.find();

            res.json(textuals);
        } catch (error) {
            res.json({ error: 'Erro ao buscar textuals!' });
        }
    },

    deleteTextual: async (req, res) => {
        const textualId = req.params.id

        try {
            const deletedTextual = await Textual.findByIdAndDelete(textualId)
            
            if (!deletedTextual) {
                res.json({ error: 'Textual não encontrado!' })

                return
            }

            res.json({ message: 'Textual excluido com sucesso!' })
        } catch (error) {
            res.json({ error: 'Erro ao excluir textua!' })
        }
    },
    
    editTextual: async (req, res) => {
        const textualId = req.params.id;
        const erros = validationResult(req);
    
        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });

            return;
        }
    
        const data = matchedData(req);
    
        try {
            const updatedTextual = await Textual.findByIdAndUpdate(textualId, data, { new: true });
            if (!updatedTextual) {
                res.json({ error: 'Textual não encontrado!' });

                return;
            }
            res.json({ updatedTextual });
        } catch (error) {
            res.json({ error: 'Erro ao editar textual!' });
        }
    }
}