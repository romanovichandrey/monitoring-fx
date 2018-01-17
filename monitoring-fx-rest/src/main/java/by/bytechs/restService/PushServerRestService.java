package by.bytechs.restService;

import by.bytechs.dto.AutoTerminationSetupDto;
import by.bytechs.dto.CashSessionsUnsuccessfulDto;
import by.bytechs.dto.MessageTypeDto;
import by.bytechs.dto.SchedulerRulesDto;
import by.bytechs.enums.MessageTypeConstrains;
import by.bytechs.enums.StatusOperation;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Defines a list of methods for accessing the pushed transaction server.
 * </p>
 *
 * @author Romanovich Andrei
 */
public interface PushServerRestService {

    /**
     * <p>Finding for unsuccessful operations in the database by the date of the beginning and
     * end of the period and the list of identifiers to the terminals.</p>
     *
     * @param beginDate      - start date of the period.
     * @param endDate        - end date of the period.
     * @param terminalIdList - list of terminal identifiers.
     * @return list of found unsuccessful operations.
     */
    List<CashSessionsUnsuccessfulDto> findUnsuccessfulOperationByDate(String beginDate, String endDate,
                                                                      List<String> terminalIdList);

    /**
     * <p>Request to complete an unsuccessful operation or generate a new operation
     * if there is a rest amount in the cash session.</p>
     *
     * @param dto          - contains data on an unsuccessful operation.
     * @param id           - id of unsuccessful cash payment.
     * @param pushExecutor - the full name of the user who completes the failed operation.
     * @param pushAmount   - the rest amount of the cash session to generate a new payment or "null" otherwise.
     * @return <ul><li>"0" - pushed successfully;</li>
     * <li>"-1" - pushed unsuccessfully;</li>
     * <li>"1" - if is the operation being performed by another process.</li>
     * </ul>
     */
    Map<Integer, CashSessionsUnsuccessfulDto> pushedTransactionOperation(CashSessionsUnsuccessfulDto dto, Integer id,
                                                                         String pushExecutor, Double pushAmount);

    /**
     * <p>Receiving all types of messages contained in the data of an unsuccessful operation.</p>
     *
     * @return all message type
     */
    Map<MessageTypeConstrains, MessageTypeDto> findAllMessageType();

    /**
     * <p>Checking the unsuccessful operation:</p>
     * <ul>
     * <li>is the operating cycle closed?</li>
     * <li>is the operation being performed by another process?</li>
     * <li>is the operation complete by another process?</li>
     * </ul>
     *
     * @param dto - contains data on an unsuccessful operation.
     * @param id  - id of unsuccessful cash payment.
     * @return <ul><li>"-1" - if is the operation being performed by another process;</li>
     * <li>"1" - if is the operating cycle closed;</li>
     * <li>"0" - if is the operation complete by another process.</li>
     * </ul>
     */
    Integer isProcessOrOperCycleTxUnsuccessfulOperation(CashSessionsUnsuccessfulDto dto, Integer id);

    boolean isAddOrUpdateComment(Integer id, String comment, Boolean typeOperation);

    boolean isReplaceSettle(StatusOperation statusOperation, Integer id, String comment, Boolean typeOperation);

    List<AutoTerminationSetupDto> findAllSettings();

    boolean updateAutoTerminationSetup(AutoTerminationSetupDto setupDto);

    Integer addRule(SchedulerRulesDto ruleDto, Integer setupId);

    boolean deleteRule(Integer id);
}