package spring.transaction.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

@DisplayName("스프링 트랜잭션 전파 관련")
@SpringBootTest
class PropagationServiceTest {

    @Autowired
    private PropagationService service;

    @Test
    @DisplayName("내부, 외부 트랜잭션을 모두 커밋한다.")
    void commitAndCommit() {
        // given
        final Runnable innerCommitTx = service.getInnerCommitTx();

        // when, then
        assertThatCode(() -> service.commitExternalTxAfter(innerCommitTx))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("내부 트랜잭션을 커밋한 후 외부 트랜잭션을 롤백한다.")
    void rollbackExternalAfterInternalCommit() {
        // given
        final Runnable innerCommitTx = service.getInnerCommitTx();

        // when, then
        assertThatCode(() -> service.rollbackExternalTxAfter(innerCommitTx))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("내부 트랜잭션을 롤백한 후 외부 트랜잭션을 커밋한다.")
    void commitExternalAfterInternalRollback() {
        // given
        final Runnable innerRollbackTx = service.getInnerRollbackTx();

        // when, then
        assertThatThrownBy(() -> service.commitExternalTxAfter(innerRollbackTx))
                .isInstanceOf(UnexpectedRollbackException.class);
    }

    @Test
    @DisplayName("새로운 내부 트랜잭션을 롤백한 후 외부 트랜잭션을 커밋한다.")
    void commitExternalAfterNewInternalRollback() {
        // given
        final Runnable innerRollbackTx = service.getInnerRollbackNewTx();

        // when, then
        assertThatCode(() -> service.commitExternalTxAfter(innerRollbackTx))
                .doesNotThrowAnyException();
    }
}
