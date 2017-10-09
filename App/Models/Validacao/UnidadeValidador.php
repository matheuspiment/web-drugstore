<?php

namespace App\Models\Validacao;

use \App\Models\Validacao\ResultadoValidacao;
use \App\Models\Entidades\Unidade;

class UnidadeValidador{

    public function validar(Unidade $unidade)
    {
        $resultadoValidacao = new ResultadoValidacao();

        if(empty($unidade->getNome()))
        {
            $resultadoValidacao->addErro('nome',"Nome: Este campo não pode ser vazio");
        }

        // if(empty($unidade->getPreco()))
        // {
        //     $resultadoValidacao->addErro('preco',"Preço: Este campo não pode ser vazio");
        // }
        //
        // if(empty($unidade->getUnidade()))
        // {
        //     $resultadoValidacao->addErro('unidade',"Unidade: Este campo não pode ser vazio");
        // }

        if(empty($unidade->getEan()))
        {
            $resultadoValidacao->addErro('ean',"EAN: Este campo não pode ser vazio");
        }

        // if(empty($unidade->getDescricao()))
        // {
        //     $resultadoValidacao->addErro('descricao',"Descrição: Este campo não pode ser vazio");
        // }

        return $resultadoValidacao;
    }
}