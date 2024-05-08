import { Link } from "react-router-dom"
import styles from './styles.module.css'
import Button from '../Button'
import Status from '../Status'
import Assunto from '../Assunto'

export default function DetalhesLivro() {
    return (
        <div className={styles.container}>
            <div className={styles.areaTopo}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>Nome do livro</h1>
                    <p className={styles.destaque}>Autor do livro</p>
                </div>
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <Status mensagem={"Disponível"} status={0} />
                    <Button tipoBotao={'primario'}>
                        <Link to="/novoemprestimo">Novo empréstimo</Link>
                    </Button>
                </div>
            </div>
            <span className={styles.linhaHorizontal} />
            <div className={styles.areaAssuntos}>
                <Assunto>Assunto 1</Assunto>
                <Assunto>Assunto 2</Assunto>
            </div>
            <div className={styles.areaConteudo}>
                <h1 className={styles.titulo}>Detalhes</h1>
                <div className={styles.cartao}>
                    <div className={styles.areaConteudoCartao}>
                        <p className={styles.paragrafo}>Nome do dado</p>
                    </div>
                    <span className={styles.linhaVertical} />
                    <div className={styles.areaConteudoCartao + " " + styles.alinhamentoDireita}>
                        <p className={styles.paragrafo}>Dado</p>
                    </div>
                </div>
            </div>
        </div>
    )
}