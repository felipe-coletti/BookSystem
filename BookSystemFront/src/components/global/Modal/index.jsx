import styles from './styles.module.css'
import Button from '../Button'

export default function Modal({ aberto, fechar, backdropClose, titulo, children }) {
    if (!aberto) return null

    return (
        <div className={styles.container}>
            <div className={styles.backdrop} onClick={backdropClose}></div>
            <div className={styles.areaConteudo}>
                <div className={styles.areaTopo}>
                    <h1 className={styles.titulo}>{titulo}</h1>
                    <Button tipoBotao={'botaoVoltar'} icone={'close'} onClick={fechar}/>
                </div>
                {children}
            </div>
        </div>
    )
}