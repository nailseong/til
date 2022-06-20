package spring.transaction.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Service
@RequiredArgsConstructor
@Slf4j
public class PropagationService {

    private final PlatformTransactionManager txManager;

    public void commitExternalTxAfter(final Runnable innerTx) {
        log.info("외부 트랜잭션 시작");
        final TransactionStatus external = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("external.isNewTransaction()={}", external.isNewTransaction());

        innerTx.run();

        log.info("external.isRollbackOnly()={}", external.isRollbackOnly());

        log.info("외부 트랜잭션 커밋");
        txManager.commit(external);
    }

    public void rollbackExternalTxAfter(final Runnable innerTx) {
        log.info("외부 트랜잭션 시작");
        final TransactionStatus external = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("external.isNewTransaction()={}", external.isNewTransaction());

        innerTx.run();

        log.info("외부 트랜잭션 롤백");
        txManager.rollback(external);
    }

    public Runnable getInnerCommitTx() {
        return () -> {
            log.info("내부 트랜잭션 시작");
            final TransactionStatus internal = txManager.getTransaction(new DefaultTransactionAttribute());
            log.info("internal.isNewTransaction()={}", internal.isNewTransaction());

            log.info("내부 트랜잭션 커밋");
            txManager.commit(internal);
        };
    }

    public Runnable getInnerRollbackTx() {
        return () -> {
            log.info("내부 트랜잭션 시작");
            final TransactionStatus internal = txManager.getTransaction(new DefaultTransactionAttribute());
            log.info("internal.isNewTransaction()={}", internal.isNewTransaction());

            log.info("내부 트랜잭션 롤백");
            txManager.rollback(internal);
        };
    }

    public Runnable getInnerRollbackNewTx() {
        return () -> {
            log.info("내부 트랜잭션 시작");
            final DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
            definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            final TransactionStatus internal = txManager.getTransaction(definition);
            log.info("internal.isNewTransaction()={}", internal.isNewTransaction());

            log.info("내부 트랜잭션 롤백");
            txManager.rollback(internal);
        };
    }
}
