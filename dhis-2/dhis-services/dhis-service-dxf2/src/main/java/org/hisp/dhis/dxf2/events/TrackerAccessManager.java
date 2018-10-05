package org.hisp.dhis.dxf2.events;

/*
 * Copyright (c) 2004-2018, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.hisp.dhis.category.CategoryOptionCombo;
import org.hisp.dhis.dataelement.DataElement;
import org.hisp.dhis.eventdatavalue.EventDataValue;
import org.hisp.dhis.program.Program;
import org.hisp.dhis.program.ProgramInstance;
import org.hisp.dhis.program.ProgramStageInstance;
import org.hisp.dhis.relationship.Relationship;
import org.hisp.dhis.trackedentity.TrackedEntityInstance;
import org.hisp.dhis.trackedentitydatavalue.TrackedEntityDataValue;
import org.hisp.dhis.user.User;

import java.util.List;

/**
 * @author Morten Olav Hansen <mortenoh@gmail.com>
 */
public interface TrackerAccessManager
{
    List<String> canRead( User user, TrackedEntityInstance trackedEntityInstance );

    List<String> canWrite( User user, TrackedEntityInstance trackedEntityInstance );

    List<String> canRead( User user, TrackedEntityInstance trackedEntityInstance, Program program );

    List<String> canWrite( User user, TrackedEntityInstance trackedEntityInstance, Program program );

    List<String> canRead( User user, ProgramInstance programInstance );

    List<String> canWrite( User user, ProgramInstance programInstance );

    List<String> canRead( User user, ProgramStageInstance programStageInstance );

    List<String> canWrite( User user, ProgramStageInstance programStageInstance );

    List<String> canRead( User user, Relationship relationship );

    List<String> canWrite( User user, Relationship relationship );

    List<String> canRead( User user, TrackedEntityDataValue dataValue );

//    List<String> canWrite( User user, TrackedEntityDataValue dataValue );

    /**
     * Checks the sharing write access to EventDataValue
     *
     * @param user User validated for write access
     * @param programStageInstance ProgramStageInstance under which the EventDataValue belongs
     * @param dataElement DataElement of EventDataValue
     * @return Empty list if write access allowed, list of errors otherwise.
     */
    List<String> canWrite( User user, ProgramStageInstance programStageInstance, DataElement dataElement );

    List<String> canRead( User user, CategoryOptionCombo categoryOptionCombo );

    List<String> canWrite( User user, CategoryOptionCombo categoryOptionCombo );
}
